INSERT INTO CUSTOMERS (cnpj, name) VALUES ('57629829000175', 'ACME CO');
INSERT INTO CUSTOMERS (cnpj, name) VALUES ('76116322000162', 'TIO PATINHAS BANK');

INSERT INTO BENEFITS (name) VALUES ('PLANO DE SAÚDE NORTEEUROPA');
INSERT INTO BENEFITS (name) VALUES ('PLANO DE SAÚDE PAMPULHA INTERMÉDICA');
INSERT INTO BENEFITS (name) VALUES ('PLANO DENTAL SORRISO');
INSERT INTO BENEFITS (name) VALUES ('PLANO DE SAÚDE MENTAL MENTE SÃ, CORPO SÃO');

-- ACME CO
INSERT INTO CUSTOMERS_BENEFITS (customers_id, benefits_id) VALUES (1, 1);
INSERT INTO CUSTOMERS_BENEFITS (customers_id, benefits_id) VALUES (1, 3);

-- TIO PATINHAS BANK
INSERT INTO CUSTOMERS_BENEFITS (customers_id, benefits_id) VALUES (2, 2);
INSERT INTO CUSTOMERS_BENEFITS (customers_id, benefits_id) VALUES (2, 3);
INSERT INTO CUSTOMERS_BENEFITS (customers_id, benefits_id) VALUES (2, 4);

INSERT INTO FIELDS (name, label, type, required) VALUES ('name', 'Name', 'text', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('cpf', 'CPF', 'text', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('admissionDate', 'Admission Date', 'date', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('email', 'Email', 'email', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('address', 'Address', 'text', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('weight', 'Weight (kg)', 'number', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('height', 'Height (cm)', 'number', true);
INSERT INTO FIELDS (name, label, type, required) VALUES ('meditated_hours', 'Meditated hours in the last 7 days', 'number', true);

INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (1, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (1, 2);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (2, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (3, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (4, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (5, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (6, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (7, 1);
INSERT INTO FIELDS_VALIDATORS (fields_id, validators_id) VALUES (8, 1);

-- NORTEEUROPA
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (1, 1);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (1, 2);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (1, 3);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (1, 4);

-- PAMPULHA
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (2, 1);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (2, 2);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (2, 3);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (2, 5);

-- SORRISO
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (3, 1);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (3, 2);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (3, 6);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (3, 7);

-- MENTE SÃ
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (4, 2);
INSERT INTO BENEFITS_FIELDS (benefits_id, fields_id) VALUES (4, 8);