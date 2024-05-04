package cn.sticki.validator.spel.constraintvalidator;

import cn.sticki.validator.spel.SpelConstraintValidator;
import cn.sticki.validator.spel.constrain.SpelNotNull;
import cn.sticki.validator.spel.result.FieldValidResult;

import java.lang.reflect.Field;

/**
 * {@link SpelNotNull} 注解校验器。
 *
 * @author 阿杆
 * @version 1.0
 * @since 2024/5/1
 */
public class SpelNotNullValidator implements SpelConstraintValidator<SpelNotNull> {

	@Override
	public FieldValidResult isValid(SpelNotNull annotation, Object obj, Field field) {
		// 判断字段值是否为空
		try {
			field.setAccessible(true);
			return new FieldValidResult(field.get(obj) != null);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Failed to access field value", e);
		}
	}

}
