<p>DBUtils是一个轻量级的持久化层框架，对JDBC进行了简单的包装</p>
<br/>
<p>提供了Query时将ResultSet转化为各种对象的方法</p>
<p>但是没提供直接将Bean进行Insert和Update的方法</p>
<p>所以直接写了个<strong>MyQueryRunner</strong>，添加了这两个功能</p>
<p>目前这个<strong>MyQueryRunner</strong>还不完善，不推荐使用</p>
