/*
 * Copyright 2010-2011 eBusiness Information, Groupe Excilys (www.excilys.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.excilys.ebi.spring.dbunit.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.dbunit.dataset.IDataSet;

import com.excilys.ebi.spring.dbunit.DBOps;
import com.excilys.ebi.spring.dbunit.DBType;
import com.excilys.ebi.spring.dbunit.DataSetFormat;

/**
 * Indicates that a test class or a test method has to load and purge the
 * database with a DBUnit dataset
 * 
 * @author <a href="mailto:slandelle@excilys.com">Stephane LANDELLE</a>
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSet {

	/**
	 * alias for locations
	 */
	String[] value() default {};

	/**
	 * @return Dataset files locations
	 */
	String[] locations() default {};

	/**
	 * @return DBUnit operation on setup (default : {@link DBOps#CLEAN_INSERT})
	 */
	DBOps setUpOperation() default DBOps.CLEAN_INSERT;

	/**
	 * @return DBUnit operation on teardown (default : {@link DBOps#NONE})
	 */
	DBOps tearDownOperation() default DBOps.NONE;

	/**
	 * @return {@link IDataSet} file format (default : {@link DataSetFormat#FLAT})
	 */
	DataSetFormat format() default DataSetFormat.FLAT;

	/**
	 * @return database type (default : {@link DBType#HSQLDB})
	 */
	DBType dbType() default DBType.HSQLDB;

	/**
	 * @return DataSource name in the Spring Context. If empty, expect one and
	 *         only one DataSource in the Spring Context.
	 */
	String dataSourceSpringName() default "";
}
