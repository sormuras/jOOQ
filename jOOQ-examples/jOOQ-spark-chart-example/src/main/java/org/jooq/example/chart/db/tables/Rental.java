/**
 * This class is generated by jOOQ
 */
package org.jooq.example.chart.db.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.example.chart.db.Keys;
import org.jooq.example.chart.db.Public;
import org.jooq.example.chart.db.tables.records.RentalRecord;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.0",
        "schema version:public_2",
    },
    date = "2016-06-30T15:44:15.143Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Rental extends TableImpl<RentalRecord> {

    private static final long serialVersionUID = 1157601407;

    /**
     * The reference instance of <code>public.rental</code>
     */
    public static final Rental RENTAL = new Rental();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RentalRecord> getRecordType() {
        return RentalRecord.class;
    }

    /**
     * The column <code>public.rental.rental_id</code>.
     */
    public final TableField<RentalRecord, Integer> RENTAL_ID = createField("rental_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('rental_rental_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.rental.rental_date</code>.
     */
    public final TableField<RentalRecord, Timestamp> RENTAL_DATE = createField("rental_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.rental.inventory_id</code>.
     */
    public final TableField<RentalRecord, Integer> INVENTORY_ID = createField("inventory_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.rental.customer_id</code>.
     */
    public final TableField<RentalRecord, Integer> CUSTOMER_ID = createField("customer_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.rental.return_date</code>.
     */
    public final TableField<RentalRecord, Timestamp> RETURN_DATE = createField("return_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.rental.staff_id</code>.
     */
    public final TableField<RentalRecord, Integer> STAFF_ID = createField("staff_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.rental.last_update</code>.
     */
    public final TableField<RentalRecord, Timestamp> LAST_UPDATE = createField("last_update", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>public.rental</code> table reference
     */
    public Rental() {
        this("rental", null);
    }

    /**
     * Create an aliased <code>public.rental</code> table reference
     */
    public Rental(String alias) {
        this(alias, RENTAL);
    }

    private Rental(String alias, Table<RentalRecord> aliased) {
        this(alias, aliased, null);
    }

    private Rental(String alias, Table<RentalRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RentalRecord, Integer> getIdentity() {
        return Keys.IDENTITY_RENTAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RentalRecord> getPrimaryKey() {
        return Keys.RENTAL_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RentalRecord>> getKeys() {
        return Arrays.<UniqueKey<RentalRecord>>asList(Keys.RENTAL_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<RentalRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RentalRecord, ?>>asList(Keys.RENTAL__RENTAL_INVENTORY_ID_FKEY, Keys.RENTAL__RENTAL_CUSTOMER_ID_FKEY, Keys.RENTAL__RENTAL_STAFF_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rental as(String alias) {
        return new Rental(alias, this);
    }

    /**
     * Rename this table
     */
    public Rental rename(String name) {
        return new Rental(name, null);
    }
}