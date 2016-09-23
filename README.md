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
2. controller的返回值类型
	1. String：
		1. 逻辑视图名
		2. redirect：重定向，语法为："redirect:url地址(包含后缀)"
		3. forward：页面转发，语法为："forward:url地址(包含后缀)"
		4. 注意：**DispatcherServlet.processDispatchResult*：处理响应--->抵用render--->调用resolveViewName得到view-->调用view的render方法进行视图渲染
			1. redirect重定向时使用restful风格(地址变量时)需要修改为

					@RequestMapping("/delete/{id}")
					public String delete(@PathVariable int id){
						userService.deleteUserInfoById(user.getId());
						return "redirect:../list";
					}
			2. 如果前缀：redirect开头-->对应的视图为RedirectView---->最终调用response的sendRedirect方法进行重定向(地址则相对于当前浏览器的地址)
			3. JstlView----->调用renderMergedOutputModel将model中的数据放入到request中--->最后调用forward方法
			4. MappingJackson2JsonView--->返回json数据