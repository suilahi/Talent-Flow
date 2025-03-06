create database TalentFlow;
use TalentFlow;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('candidate', 'recruiter') NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Candidates Table (inherits from users)
CREATE TABLE candidates (
                            id INT ,
                            phone VARCHAR(15),
                            cv VARCHAR(255),
                            FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

-- Recruiters Table (inherits from users)
CREATE TABLE recruiters (
                            id INT ,
                            company VARCHAR(255),
                            FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE job_offers (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            title VARCHAR(255) NOT NULL,
                            description TEXT NOT NULL,
                            recruiter_id INT,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (recruiter_id) REFERENCES recruiters(id) ON DELETE CASCADE
);


CREATE TABLE offer_status (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              job_id INT,
                              candidate_id INT,
                              status ENUM('pending', 'accepted', 'rejected') DEFAULT 'pending',
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              FOREIGN KEY (job_id) REFERENCES job_offers(id) ON DELETE CASCADE,
                              FOREIGN KEY (candidate_id) REFERENCES candidates(id) ON DELETE CASCADE
);