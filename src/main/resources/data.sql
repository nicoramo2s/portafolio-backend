INSERT INTO personal_info (first_name, last_name, title, profile_description, profile_image_url, years_of_experience, email, phone, linkedin_url, github_url) VALUES
('Dario Nicolas', 'Ramos', 'Backend Developer', 'Apasionado por el desarrollo web con experiencia en Java, Spring Boot y Angular. Disfruto construyendo soluciones robustas y escalables.', 'img/perfil-linkedin.jpg', 5, 'nicolasramo2s@hotmail.com', '+542645811779', 'https://linkedin.com/in/dario-nicolas-ramos', 'https://github.com/nicoramo2s');

INSERT INTO skills (name, level_percentage, icon_class, personal_info_id) VALUES
('Java', 90, 'img/logos/java.png', 1),
('GitHub', 90, 'img/logos/github.png', 1),
('Spring Boot', 85, 'img/logos/spring-boot.png', 1),
('PostgreSQL', 80, 'img/logos/servidor-sql.png', 1),
('HTML', 95, 'img/logos/html-5.png', 1),
('CSS', 90, 'img/logos/css-3.png', 1),
('JavaScript', 75, 'img/logos/js.png', 1),
('Angular', 80, 'img/logos/angular-v.png', 1);

INSERT INTO users (username, password, enabled) VALUES
('admin', '$2a$10$eLx7pnfI6DuSdjNwMGpdPOBt0PxEKXDNbrIPmU7MB6KbgLo44yv3S', TRUE);