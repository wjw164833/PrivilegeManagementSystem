package xyz.wjw.priviligemanagementsystem.enums;


import xyz.wjw.priviligemanagementsystem.vo.EnumResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 枚举  用户状态等
 */
public enum ValidEnum {
    EFFECTIVE("0","有效"),INVALID("1","无效");

    private String key;
    private String value;
    ValidEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public static String getEnumValue(String key) {
        ValidEnum[] validEnums = ValidEnum.values();
        for (ValidEnum validEnum : validEnums) {
            if (validEnum.getKey().equals(key)) {
                return validEnum.getValue();
            }
        }
        return null;
    }
    public static List<EnumResult> getEnumList() {
        ValidEnum[] validEnums = ValidEnum.values();
        List<EnumResult> result = Stream.of(validEnums).map(
                entry -> new EnumResult(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        return result;
    }
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
