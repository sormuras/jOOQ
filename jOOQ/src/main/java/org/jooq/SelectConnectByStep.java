/**
 * Copyright (c) 2009-2015, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq;

import static org.jooq.SQLDialect.CUBRID;
// ...
// ...

import org.jooq.impl.DSL;

/**
 * This type is used for the {@link Select}'s DSL API when selecting generic
 * {@link Record} types.
 * <p>
 * Example: <code><pre>
 * -- get all authors' first and last names, and the number
 * -- of books they've written in German, if they have written
 * -- more than five books in German in the last three years
 * -- (from 2011), and sort those authors by last names
 * -- limiting results to the second and third row
 *
 *   SELECT T_AUTHOR.FIRST_NAME, T_AUTHOR.LAST_NAME, COUNT(*)
 *     FROM T_AUTHOR
 *     JOIN T_BOOK ON T_AUTHOR.ID = T_BOOK.AUTHOR_ID
 *    WHERE T_BOOK.LANGUAGE = 'DE'
 *      AND T_BOOK.PUBLISHED > '2008-01-01'
 * GROUP BY T_AUTHOR.FIRST_NAME, T_AUTHOR.LAST_NAME
 *   HAVING COUNT(*) > 5
 * ORDER BY T_AUTHOR.LAST_NAME ASC NULLS FIRST
 *    LIMIT 2
 *   OFFSET 1
 *      FOR UPDATE
 *       OF FIRST_NAME, LAST_NAME
 *       NO WAIT
 * </pre></code> Its equivalent in jOOQ <code><pre>
 * create.select(TAuthor.FIRST_NAME, TAuthor.LAST_NAME, create.count())
 *       .from(T_AUTHOR)
 *       .join(T_BOOK).on(TBook.AUTHOR_ID.equal(TAuthor.ID))
 *       .where(TBook.LANGUAGE.equal("DE"))
 *       .and(TBook.PUBLISHED.greaterThan(parseDate('2008-01-01')))
 *       .groupBy(TAuthor.FIRST_NAME, TAuthor.LAST_NAME)
 *       .having(create.count().greaterThan(5))
 *       .orderBy(TAuthor.LAST_NAME.asc().nullsFirst())
 *       .limit(2)
 *       .offset(1)
 *       .forUpdate()
 *       .of(TAuthor.FIRST_NAME, TAuthor.LAST_NAME)
 *       .noWait();
 * </pre></code> Refer to the manual for more details
 *
 * @author Lukas Eder
 */
public interface SelectConnectByStep<R extends Record> extends SelectGroupByStep<R> {

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     */
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectBy(Condition condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     */
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectBy(Field<Boolean> condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     *
     * @deprecated - 3.8.0 - [#4763] - Use {@link #connectBy(Condition)} or
     *             {@link #connectBy(Field)} instead. Due to ambiguity between
     *             calling this method using {@link Field#equals(Object)}
     *             argument, vs. calling the other method via a
     *             {@link Field#equal(Object)} argument, this method will be
     *             removed in the future.
     */
    @Deprecated
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectBy(Boolean condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(SQL)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectBy(SQL sql);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectBy(String sql);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, Object...)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectBy(String sql, Object... bindings);

    /**
     * Add an Oracle-specific <code>CONNECT BY</code> clause to the query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, QueryPart...)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectBy(String sql, QueryPart... parts);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     */
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectByNoCycle(Condition condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     */
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectByNoCycle(Field<Boolean> condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     *
     * @deprecated - 3.8.0 - [#4763] - Use {@link #connectByNoCycle(Condition)}
     *             or {@link #connectByNoCycle(Field)} instead. Due to ambiguity
     *             between calling this method using
     *             {@link Field#equals(Object)} argument, vs. calling the other
     *             method via a {@link Field#equal(Object)} argument, this
     *             method will be removed in the future.
     */
    @Deprecated
    @Support({ CUBRID })
    SelectConnectByConditionStep<R> connectByNoCycle(Boolean condition);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(SQL)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectByNoCycle(SQL sql);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectByNoCycle(String sql);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, Object...)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectByNoCycle(String sql, Object... bindings);

    /**
     * Add an Oracle-specific <code>CONNECT BY NOCYCLE</code> clause to the
     * query
     * <p>
     * <b>NOTE</b>: When inserting plain SQL into jOOQ objects, you must
     * guarantee syntax integrity. You may also create the possibility of
     * malicious SQL injection. Be sure to properly use bind variables and/or
     * escape literals when concatenated into SQL clauses!
     *
     * @see DSL#condition(String, QueryPart...)
     * @see SQL
     */
    @Support({ CUBRID })
    @PlainSQL
    SelectConnectByConditionStep<R> connectByNoCycle(String sql, QueryPart... parts);
}
