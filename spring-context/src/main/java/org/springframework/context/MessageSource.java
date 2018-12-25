/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context;

import java.util.Locale;

import org.springframework.lang.Nullable;

/**
 * 解决消息的策略，为这些消息，支持参数化，和国际化
 * Strategy interface for resolving messages, with support for the parameterization
 * and internationalization of such messages.
 *
 * <p>Spring provides two out-of-the-box implementations for production:
 * <ul>
 * <li>{@link org.springframework.context.support.ResourceBundleMessageSource},
 * built on top of the standard {@link java.util.ResourceBundle}
 * <li>{@link org.springframework.context.support.ReloadableResourceBundleMessageSource},
 * being able to reload message definitions without restarting the VM
 * </ul>
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see org.springframework.context.support.ResourceBundleMessageSource
 * @see org.springframework.context.support.ReloadableResourceBundleMessageSource
 */
public interface MessageSource {

	/**
	 * 解析code对应的信息进行返回，如果对应的code不能被解析则返回默认信息defaultMessage。
	 * Try to resolve the message. Return default message if no message was found.
	 *
	 * @param code           the code to lookup up, such as 'calculator.noRateSet'. Users of
	 *                       this class are encouraged to base message names on the relevant fully
	 *                       qualified class name, thus avoiding conflict and ensuring maximum clarity.
	 *                       需要进行解析的code，对应资源文件中的一个属性名
	 * @param args           an array of arguments that will be filled in for params within
	 *                       the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
	 *                       or {@code null} if none.
	 *                       需要用来替换code对应的信息中包含参数的内容，如：{0},{1,date},{2,time}
	 * @param defaultMessage a default message to return if the lookup fails 当对应code对应的信息不存在时需要返回的默认值
	 * @param locale         the locale in which to do the lookup 对应的Locale
	 * @return the resolved message if the lookup was successful;
	 * otherwise the default message passed as a parameter
	 * @see java.text.MessageFormat
	 */
	String getMessage(String code, @Nullable Object[] args, @Nullable String defaultMessage, Locale locale);

	/**
	 * 解析code对应的信息进行返回，如果对应的code不能被解析则抛出异常NoSuchMessageException
	 * Try to resolve the message. Treat as an error if the message can't be found.
	 *
	 * @param code   the code to lookup up, such as 'calculator.noRateSet'
	 *               需要进行解析的code，对应资源文件中的一个属性名
	 * @param args   an array of arguments that will be filled in for params within
	 *               the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
	 *               or {@code null} if none.
	 *               需要用来替换code对应的信息中包含参数的内容，如：{0},{1,date},{2,time}
	 * @param locale the locale in which to do the lookup 对应的Locale
	 * @return the resolved message
	 * @throws NoSuchMessageException if the message wasn't found 如果对应的code不能被解析则抛出该异常
	 * @see java.text.MessageFormat
	 */
	String getMessage(String code, @Nullable Object[] args, Locale locale) throws NoSuchMessageException;

	/**
	 * 通过传递的MessageSourceResolvable对应来解析对应的信息
	 *
	 * Try to resolve the message using all the attributes contained within the
	 * {@code MessageSourceResolvable} argument that was passed in.
	 * <p>NOTE: We must throw a {@code NoSuchMessageException} on this method
	 * since at the time of calling this method we aren't able to determine if the
	 * {@code defaultMessage} property of the resolvable is {@code null} or not.
	 *
	 * @param resolvable the value object storing attributes required to resolve a message
	 * @param locale     the locale in which to do the lookup 对应的Locale
	 * @return the resolved message
	 * @throws NoSuchMessageException if the message wasn't found 如不能解析则抛出该异常
	 * @see java.text.MessageFormat
	 */
	String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException;

}
