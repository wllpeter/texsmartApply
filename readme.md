### windows IDEA 需要把 tencent_ai_texsmart.dll  放到  C:\Windows\System32 目录下  


### Linux 需要把 libtencent_ai_texsmart.so  放到  usr/lib 目录下  

并且增加权限
chmod 777 libtencent_ai_texsmart.so

###扩展自定义词
####text_ner_data.txt 文件示例

中华小当家	*	0,5,person.generic,1

这么奇怪	*	0,4,person.generic,1

木下	*	0,2,person.generic,1

####text_seg_data.txt 文件示例

熊大熊二	*	熊大|熊二	熊大|熊二

木下	*	木|下	木下

你是谁啊	*	你是谁|啊	你是谁|啊

怎么这么奇怪	*	怎么|这么奇怪	怎么|这么奇怪

中华小当家	*	中华小当家	中华小当家

###texsmart网址

在线演示地址
https://texsmart.qq.com/zh/
sdk下载地址
https://ai.tencent.com/ailab/nlp/texsmart/zh/download.html
TexSmart HTTP API
https://ai.tencent.com/ailab/nlp/texsmart/zh/api.html#java_example
