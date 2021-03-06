/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cobar.manager.jdbcmock.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SalesOrder {

    public String getOrderNumber();

    public void setOrderNumber(String orderNumber);

    public String getRegion();

    public void setRegion(String region);

    public double getTotalPrice();

    public void setTotalPrice(double totalPrice);

    public void loadDataFromDB(ResultSet resultSet) throws SQLException;

    public String getPriceLevel();

    @Override
    public String toString();

}
