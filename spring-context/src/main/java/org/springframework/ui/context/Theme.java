/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.ui.context;

import org.springframework.context.MessageSource;

/**
 * 一个主题可以解决，主题特定的消息，代码，文件路径等
 * 暴漏的MessageSource接口就支持，主题特定的参数化，国际化
 * A Theme can resolve theme-specific messages, codes, file paths, etcetera
 * (e&#46;g&#46; CSS and image files in a web environment).
 * The exposed {@link org.springframework.context.MessageSource} supports
 * theme-specific parameterization and internationalization.
 *
 * @author Juergen Hoeller
 * @since 17.06.2003
 * @see ThemeSource
 * @see org.springframework.web.servlet.ThemeResolver
 */
public interface Theme {

	/**
	 * 返回主题名称
	 * Return the name of the theme.
	 * @return the name of the theme (never {@code null})
	 */
	String getName();

	/**
	 * 返回特定的支持当前主题的消息源
	 * Return the specific MessageSource that resolves messages
	 * with respect to this theme.
	 * @return the theme-specific MessageSource (never {@code null})
	 */
	MessageSource getMessageSource();

}
