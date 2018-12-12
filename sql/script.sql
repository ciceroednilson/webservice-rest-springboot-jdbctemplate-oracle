--CRIANDO A SEQUENCE
CREATE SEQUENCE cicero.seq_id_usuario
MINVALUE 1  
MAXVALUE 9999999999
START WITH 1       
INCREMENT BY 1;



--CRIANDO A TABELA
CREATE TABLE cicero.tb_usuario(
    id_usuario INT NOT NULL PRIMARY KEY,  
    ds_login   VARCHAR(20),
    ds_senha   VARCHAR(20),
    fl_ativo   NUMBER(1)
 
);


--CRIANDO A TRIGGER QUE VAI INSERIR A CHAVE DA NOSSA TABELA NA EXECUÇÃO DO INSERT
CREATE OR REPLACE TRIGGER cicero.tr_insert_id_usuario
                  BEFORE INSERT ON tb_usuario FOR EACH ROW       
BEGIN
 
SELECT seq_id_usuario.NEXTVAL
INTO :NEW.id_usuario
FROM DUAL;
END;


