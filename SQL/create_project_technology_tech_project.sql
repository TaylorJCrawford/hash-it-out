CREATE TABLE project (
    project_id int PRIMARY KEY AUTO_INCREMENT,
    client_id int,
    project_name varchar(255),
    project_value decimal,
    start_date DATE,
    end_date DATE,
    tech_lead int
);

CREATE TABLE technology (
    technology_id int PRIMARY KEY AUTO_INCREMENT,
    technology_name varchar(50)
);

CREATE TABLE tech_project (
    technology_id int,
    project_id int
    FOREIGN KEY(technology_id) REFERENCES technology(technology_id),
    FOREIGN KEY(project_id) REFERENCES project(project_id),
    PRIMARY  KEY(technology_id, project_id)
);

