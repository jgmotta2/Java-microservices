-- Adiciona a nova coluna
ALTER TABLE tb_product ADD COLUMN image_url VARCHAR(255);

-- Atualiza os registros existentes
UPDATE tb_product SET image_url = 'https://emporioxingu.com/wp-content/uploads/2022/02/castanha-caju-w1-comsal.jpg' WHERE description = 'Castanha de Caju';
UPDATE tb_product SET image_url = 'https://images.unsplash.com/photo-1627435601361-ec25f5b1d0e5?auto=format&fit=crop&w=800' WHERE description = 'Chá Verde';
UPDATE tb_product SET image_url = 'https://images.unsplash.com/photo-1585744259332-111384f5def9?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D' WHERE description = 'Erva Mate';
UPDATE tb_product SET image_url = 'https://images.unsplash.com/photo-1587049352851-8d4e89133924?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D' WHERE description = 'Mel Orgânico';