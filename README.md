# springmvc
springmvc学习_静态资源

##
1. springmvc配置文件
	1. 静态资源引入：该资源不会通过servlet请求进行处理
		1. location：指定该请求反问的静态资源在服务器中的位置
		2. mapping：请求的url地址

				<mvc:resources location="/resources/upload/" mapping="/resources/upload/**"/>
	2. 指定特定请求的跳转
		1. path:请求的地址
		2. view-name：视图名
		
				<mvc:view-controller path="/" view-name="redirect:/UserAction/list"/>