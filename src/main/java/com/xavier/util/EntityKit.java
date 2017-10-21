package com.xavier.util;

import java.lang.reflect.Field;
import java.util.UUID;

public class EntityKit {

    /*通过验证*/
    public static String VALIDATE_PASSED = "";

    /* 字符串类型 */
    private static String STRING_TYPE = "class java.lang.String";
    /* 整型 */
    private static String INTEGER_TYPE = "class java.lang.Integer";
    /* 双精度浮点型 */
    private static String DOUBLE_TYPE = "class java.lang.Double";

    /**
     * <p>校验entity的必填字段</p>
     *
     * @param entity         (校验的对象)
     * @param requiredFields (必填字段，多个String或者String[])
     * @return String (如果通过校验则返回一个空串，否则返回错误提示信息)
     * @throws IllegalAccessException
     */
    public static String requiredFieldsValidate(Object entity, String... requiredFields) throws IllegalAccessException {
        StringBuffer result = new StringBuffer("");
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            for (String fieldName : requiredFields) {
                /* 字段名匹配 */
                if (fieldName.equals(field.getName())) {
                    /*判断类型*/
                    if (STRING_TYPE.equals(field.getGenericType().toString())) {
                        if (StringKit.isBlank((String) field.get(entity))) {
                            result.append(field.getName() + " is required.<br />");
                        }
                    }
                    if (INTEGER_TYPE.equals(field.getGenericType().toString())
                            || DOUBLE_TYPE.equals(field.getGenericType().toString())) {
                        if (null == field.get(entity)) {
                            result.append(field.getName() + " is required.<br />");
                        }
                    }
                }
            }
        }
        return result.toString();
    }

    /**
     * <p>生成UUID</p>
     *
     * @return String (UUID 序列)
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * <p>生成指定数量的UUID</p>
     *
     * @return String[] (UUID 序列数组)
     */
    public static String[] generateUUIDs(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = generateUUID();
        }
        return ss;
    }

}
