-- Flyway migration: create investments table
-- Version: 1

CREATE TABLE investments (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    buy_price DECIMAL(19,4),
    current_price DECIMAL(19,4),
    quantity INTEGER,
    quota_buy_value DECIMAL(19,4),
    quota_current_value DECIMAL(19,4),
    admin_fee_percent DECIMAL(10,4),
    face_value DECIMAL(19,4),
    interest_rate DECIMAL(10,4),
    years_to_maturity INTEGER,
    pre_fixed BOOLEAN,
    investment_type VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Index for faster queries by investment type
CREATE INDEX idx_investments_type ON investments(investment_type);

-- Index for name searches
CREATE INDEX idx_investments_name ON investments(name);