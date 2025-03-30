-- Estados de usuario
INSERT INTO user_status (status_id, name, description) VALUES (1, 'ACTIVE', 'Usuario activo')
    ON CONFLICT (status_id) DO NOTHING;
INSERT INTO user_status (status_id, name, description) VALUES (2, 'INACTIVE', 'Usuario inactivo')
    ON CONFLICT (status_id) DO NOTHING;

-- Roles
INSERT INTO auth_role (id, name, description, status) VALUES (1, 'USER', 'Rol por defecto para usuarios', 1)
    ON CONFLICT (id) DO NOTHING;
INSERT INTO auth_role (id, name, description, status) VALUES (2, 'ADMIN', 'Administrador del sistema', 1)
    ON CONFLICT (id) DO NOTHING;
