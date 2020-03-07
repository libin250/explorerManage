package edu.ynmd.tools;

/**
 * @Author:lb
 * @date:2020/3/5 11:01
 * @description:数据库操作封装
 */

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Table;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.util.StringUtils;

public class DataHelper {

    public DataHelper() {
    }

    public static String stringifyEntityFields(Class<?> entityClazz) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = entityClazz.getDeclaredFields();

        for(int i = 0; i < fields.length; ++i) {
            Field field = fields[i];
            Column column = (Column)AnnotationUtils.findAnnotation(field, Column.class);
            String colName;
            if (column != null) {
                colName = column.name();
            } else {
                colName = field.getName();
            }

            builder.append(colName).append(" AS ").append(field.getName());
            if (i < fields.length - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    public static String entityTable(Class<?> entityClazz) {
        Table table = (Table)AnnotationUtils.findAnnotation(entityClazz, Table.class);
        return table == null ? null : table.name();
    }

    public static String selectSQL(Class<?> entityClazz) {
        return " SELECT " + stringifyEntityFields(entityClazz) + " FROM " + entityTable(entityClazz) + " ";
    }

    public static <T> PageData<T> pageEntity(JdbcTemplate jdbcTemplate, int pageNo, int pageSize, Class<T> entityClazz, Object... args) {
        String querySql = selectSQL(entityClazz);
        return pageQuery(jdbcTemplate, querySql, pageNo, pageSize, entityClazz, args);
    }

    public static List<ValueLabel> valueLabels(JdbcTemplate jdbcTemplate, String querySql, Object... args) {
        List entityList = (List)jdbcTemplate.query(querySql, args, new RowMapperResultSetExtractor(new BeanPropertyRowMapper(ValueLabel.class)));
        return entityList;
    }


    public static <T> PageData<T> pageQuery(JdbcTemplate jdbcTemplate, String querySql, int totalCount, int pageNo, int pageSize, Class<T> entityClazz, Object... args) {
        if (!StringUtils.hasText(querySql)) {
            return new PageData(pageNo, pageSize, 0L, (List)null);
        } else {
            querySql = sqlPresets(querySql);
            int begin = (pageNo - 1) * pageSize;
            String pageSql = "SELECT * FROM (" + querySql + ") CA_TL LIMIT " + begin + ", " + pageSize;
            Object rowMapper;
            if (entityClazz == Map.class) {
                rowMapper = new ColumnMapRowMapper();
            } else {
                rowMapper = new BeanPropertyRowMapper(entityClazz);
            }

            List entityList = jdbcTemplate.query(pageSql, (RowMapper)rowMapper, args);
            return new PageData(pageNo, pageSize, (long)totalCount, entityList);
        }
    }

    public static <T> PageData<T> pageQuery(JdbcTemplate jdbcTemplate, String querySql, int pageNo, int pageSize, Class<T> entityClazz, Object... args) {
        String countSql = "SELECT COUNT(*) FROM (" + querySql + ") CA_T";
        Integer totalCount = (Integer)jdbcTemplate.queryForObject(countSql, new SingleColumnRowMapper(Integer.class));
        return pageQuery(jdbcTemplate, querySql, totalCount, pageNo, pageSize, entityClazz, args);
    }

    public static <T> List<T> queryForList(JdbcTemplate jdbcTemplate, String querySql, Class<T> entityClazz, Object... args) {
        return (List)jdbcTemplate.query(querySql, args, new RowMapperResultSetExtractor(new BeanPropertyRowMapper(entityClazz)));
    }

    public static <T> T queryForEntity(JdbcTemplate jdbcTemplate, String querySql, Class<T> entityClazz, Object... args) {
        List<T> list = queryForList(jdbcTemplate, querySql, entityClazz, args);
        return list != null && list.size() > 0 ? list.get(0) : null;
    }

    private static String sqlPresets(String sql) {
        while(true) {
            sql = StringUtils.trimTrailingWhitespace(sql);
            if (!sql.endsWith(";")) {
                return sql;
            }

            sql = sql.substring(0, sql.length() - 1);
        }
    }

    public static String keep2(Double d) {
        BigDecimal bg = new BigDecimal(d);
        return keep2(bg);
    }

    public static String keep2(BigDecimal bg) {
        double f = bg.setScale(2, 4).doubleValue();
        return String.valueOf(f);
    }

    public static String dateFormat(Date d, String pattern) {
        if (d == null) {
            return null;
        } else {
            LocalDateTime now = LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
            DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
            return now.format(format);
        }
    }

    public static Date dateParse(String dateStr, String pattern) {
        if (dateStr == null) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
            ZonedDateTime zd = date.atZone(ZoneId.systemDefault());
            return Date.from(zd.toInstant());
        }
    }
}
