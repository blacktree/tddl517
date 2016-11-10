package com.taobao.tddl.repo.oceanbase;

import com.taobao.tddl.common.jdbc.IConnection;
import com.taobao.tddl.common.jdbc.ITransactionPolicy;
import com.taobao.tddl.common.model.SqlMetaData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class OBConnectionWrapper implements IConnection {

    Connection conn;

    public OBConnectionWrapper(Connection conn) {
        this.conn = conn;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return conn.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return conn.isWrapperFor(iface);
    }

    @Override
    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return conn.prepareCall(sql);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        return conn.nativeSQL(sql);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return conn.getAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        conn.setAutoCommit(autoCommit);
    }

    @Override
    public void commit() throws SQLException {
        conn.commit();
    }

    @Override
    public void rollback() throws SQLException {
        conn.rollback();
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return conn.isClosed();
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return conn.getMetaData();
    }

    @Override
    public void setMetaData(SqlMetaData sqlMetaData) {

    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return conn.isReadOnly();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        conn.setReadOnly(readOnly);
    }

    @Override
    public String getCatalog() throws SQLException {
        return conn.getCatalog();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        conn.setCatalog(catalog);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return conn.getTransactionIsolation();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        conn.setTransactionIsolation(level);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return conn.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        conn.clearWarnings();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return conn.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
        return conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return conn.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return conn.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        conn.setTypeMap(map);
    }

    @Override
    public int getHoldability() throws SQLException {
        return conn.getHoldability();
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        conn.setHoldability(holdability);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return conn.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return conn.setSavepoint(name);
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        conn.rollback(savepoint);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        conn.releaseSavepoint(savepoint);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException {
        return conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
                                              int resultSetHoldability) throws SQLException {
        return conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
                                         int resultSetHoldability) throws SQLException {
        return conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return conn.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return conn.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return conn.prepareStatement(sql, columnNames);
    }

    @Override
    public Clob createClob() throws SQLException {
        return conn.createClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return conn.createBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return conn.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return conn.createSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return conn.isValid(timeout);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        conn.setClientInfo(name, value);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return conn.getClientInfo(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return conn.getClientInfo();
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        conn.setClientInfo(properties);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return conn.createArrayOf(typeName, elements);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return conn.createStruct(typeName, attributes);
    }

    @Override
    public void kill() throws SQLException {
    }

    @Override
    public void cancelQuery() throws SQLException {
    }

    @Override
    public long getLastInsertId() {
        return 0;
    }

    @Override
    public void setLastInsertId(long id) {
    }

    @Override
    public List<Long> getGeneratedKeys() {
        return new ArrayList<Long>();
    }

    @Override
    public void setGeneratedKeys(List<Long> ids) {
    }

    @Override
    public ITransactionPolicy getTrxPolicy() {
        return null;
    }

    @Override
    public void setTrxPolicy(ITransactionPolicy trxPolicy) {

    }

    @Override
    public String getEncoding() {
        return null;
    }

    @Override
    public void setEncoding(String encoding) {
    }

    @Override
    public String getSqlMode() {
        return null;
    }

    @Override
    public void setSqlMode(String sqlMode) {
    }

    @Override
    public SqlMetaData getSqlMetaData() {
        return null;
    }

}
