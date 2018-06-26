tddl
====

<table>
<thead>
<th>dataId</th>
<th>value</th>
<th>备注</th>
</thead>
<tbody>
  <tr>
  <td>com.taobao.tddl.v1_tddl_sample_dbgroups</td>
  <td>tddl_group_0,tddl_group_1</td>
  <td>com.taobao.tddl.v1_{appName}_dbgroups matrix的配置</td>
  </tr>
  <tr>
    <td>com.taobao.tddl.jdbc.group_V2.4.1_tddl_group_0</td>
    <td>qatest_normal_0:r2w10p0,qatest_normal_0_bac:r10w0p0</td>
    <td>可以一主多备配置 com.taobao.tddl.jdbc.group_V2.4.1_{dbGroupKey}</td>
    </tr>
    <tr>
      <td>com.taobao.tddl.atom.global.qatest_normal_0</td>
      <td>ip=127.0.0.1 
          port=3306 
          dbName=qatest_normal_0 
          dbType=mysql 
          dbStatus=RW</td>
      <td>com.taobao.tddl.atom.global.{dbKey} </td>
      </tr>
      <tr>
        <td>com.taobao.tddl.atom.app.tddl_sample.qatest_normal_0 </td>
        <td>userName=tddl 
            minPoolSize=1 
            maxPoolSize=100</td>
        <td>com.taobao.tddl.atom.app.{appName}.{dbKey}       
            userName=tddl 
            minPoolSize=20 
            maxPoolSize=40 
            idleTimeout=20 
            blockingTimeout=10000 
            preparedStatementCacheSize=1000          
            connectionProperties=characterEncoding=UTF-8;autoReconnect=true;connectionInitSql=set names utf8mb4;
            readRestrictTimes=0 
            writeRestrictTimes=0 
            timeSliceInMillis=0 </td>
        </tr>
        <tr>
          <td>com.taobao.tddl.atom.passwd.qatest_normal_0.mysql.tddl</td>
          <td>encPasswd=tddl</td>
          <td>com.taobao.tddl.atom.passwd.{dbName}.{dbType}.{userName} 
              encPasswd=密码 
              encKey=密钥</td>
          </tr>
          <tr>
            <td>com.taobao.tddl.jdbc.extra_config.group_V2.4.1_tddl_group_0.tddl_sample</td>
            <td>{"sqlForbid":[],"sqlDsIndex":{},"tabDsIndex":{},"defaultMain":"true"}</td>
            <td>com.taobao.tddl.jdbc.extra_config.group_V2.4.1_{dbGroupKey}.{appName}</td>
            </tr>
</tbody>
</table>

<table>
<thead>
<th>环境变量</th>
<th>默认值</th>
<th>备注</th>
</thead>
<tbody>
    <tr>
    <td>DIAMOND_CONFIG_SERVER_ADDRESS</td>
    <td>localhost</td>
    <td>种子服务器的地址，客户端会从该地址的/url路径读取配置服务器的域名</td>
    </tr>
    <tr>
        <td>DIAMOND_CONFIG_SERVER_PORT</td>
        <td>80</td>
        <td>种子服务器的端口</td>
    </tr>
    <tr>
        <td>DIAMOND_POLL_TIME_INTERVAL</td>
        <td>15</td>
        <td>客户端拉取配置的间隔</td>
    </tr>
</tbody>
</table>	 

## 坑
* 因为tddl会把表名都转换为大写，所以一定要设置数据库表名忽略大小写。通过在my.cnf的mysqld的下边写入lower_case_table_names=1 
* 由于主动从主库查是通过调用GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(0);实现的，其中参数0表示从diamond配置的第一个库中读取数据，所以在进行设置diamond的时候一定要把rw读写库写到第一个
虽然读写分离了，但是有时需要从主库查，可以通过调用GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(0);主动从主库查询 指定某个数据库和表进行执行可以参考SimpleHintParser里的注释GroupDataSourceRouteHelper.executeByGroupDataSourceIndex(0); 当使用该方法进行主动选择db的时候，并且第一次使用某个表的时候，因为要读取该表的meta数据，会使用掉threadlocal里的数据，所以该次请求会成为没有主动选择db的操作 
