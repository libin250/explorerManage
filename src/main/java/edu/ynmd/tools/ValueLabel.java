package edu.ynmd.tools;

/**
 * @Author:lb
 * @date:2020/3/9 16:47
 * @description:
 */
public class ValueLabel {
    private String value;
    private String label;

    public String getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ValueLabel)) {
            return false;
        } else {
            ValueLabel other = (ValueLabel)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                Object this$label = this.getLabel();
                Object other$label = other.getLabel();
                if (this$label == null) {
                    if (other$label != null) {
                        return false;
                    }
                } else if (!this$label.equals(other$label)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ValueLabel;
    }

    public int hashCode() {
        Object $value = this.getValue();
        int result = 59 + ($value == null ? 43 : $value.hashCode());
        Object $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        return result;
    }

    public String toString() {
        return "ValueLabel(value=" + this.getValue() + ", label=" + this.getLabel() + ")";
    }

    public ValueLabel(final String value, final String label) {
        this.value = value;
        this.label = label;
    }
}

