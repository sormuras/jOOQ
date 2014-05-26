/**
 * This class is generated by jOOQ
 */
package org.jooq.test.mysql2.generatedclasses.tables.records;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "t_959", schema = "test2")
public class T_959Record extends org.jooq.impl.TableRecordImpl<org.jooq.test.mysql2.generatedclasses.tables.records.T_959Record> implements org.jooq.Record2<org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords, org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters> {

	private static final long serialVersionUID = 1507717826;

	/**
	 * Setter for <code>test2.t_959.java_keywords</code>.
	 */
	public void setJavaKeywords(org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>test2.t_959.java_keywords</code>.
	 */
	@javax.persistence.Column(name = "java_keywords", length = 12)
	public org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords getJavaKeywords() {
		return (org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords) getValue(0);
	}

	/**
	 * Setter for <code>test2.t_959.special_characters</code>.
	 */
	public void setSpecialCharacters(org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>test2.t_959.special_characters</code>.
	 */
	@javax.persistence.Column(name = "special_characters", length = 5)
	public org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters getSpecialCharacters() {
		return (org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords, org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords, org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords> field1() {
		return org.jooq.test.mysql2.generatedclasses.tables.T_959.T_959.JAVA_KEYWORDS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters> field2() {
		return org.jooq.test.mysql2.generatedclasses.tables.T_959.T_959.SPECIAL_CHARACTERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords value1() {
		return getJavaKeywords();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters value2() {
		return getSpecialCharacters();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T_959Record value1(org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords value) {
		setJavaKeywords(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T_959Record value2(org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters value) {
		setSpecialCharacters(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T_959Record values(org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords value1, org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters value2) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached T_959Record
	 */
	public T_959Record() {
		super(org.jooq.test.mysql2.generatedclasses.tables.T_959.T_959);
	}

	/**
	 * Create a detached, initialised T_959Record
	 */
	public T_959Record(org.jooq.test.mysql2.generatedclasses.enums.T_959JavaKeywords javaKeywords, org.jooq.test.mysql2.generatedclasses.enums.T_959SpecialCharacters specialCharacters) {
		super(org.jooq.test.mysql2.generatedclasses.tables.T_959.T_959);

		setValue(0, javaKeywords);
		setValue(1, specialCharacters);
	}
}