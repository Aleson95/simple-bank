CREATE TABLE IF NOT EXISTS saving_account
(
    id bigserial CONSTRAINT saving_account_pkey PRIMARY KEY,
    saving_tenor INTEGER,
    first_deposit_amount numeric,
    monthly_deposit_amount numeric,
    purpose_of_saving varchar (255),
    version       INTEGER,
    created_by    VARCHAR(50),
    created_dt    TIMESTAMP,
    changed_by    VARCHAR(50),
    changed_dt    TIMESTAMP
);