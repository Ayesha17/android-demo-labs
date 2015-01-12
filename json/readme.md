
# 初于效率和性能的考虑，经常会用到第三方json工具。但是我们使用中经常会担心几件事情。

1. 是不是所有的字段名称都能序列或者反序列？
2. 所有字段类型是不是都支持，会不会抛出异常？


## FastJson

误区：
序列化/反序列化名称和字段名本身没有直接联系。与get/set关联。

特点：

1. 快速(比gson快6倍)
2. 支持JSONFiled,可配置序列化顺序，可自定义字段名称，可自定义日期格式，可控制某字段的序列化或者反序列化。

[常见问题](https://github.com/alibaba/fastjson/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98)
[下载](http://repo1.maven.org/maven2/com/alibaba/fastjson/)

