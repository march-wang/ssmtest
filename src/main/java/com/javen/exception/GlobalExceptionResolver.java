package com.javen.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ThresholdingOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.javen.common.BaseResult;

 

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private final Logger Log  = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		
		Log.error("访问" + request.getRequestURI() +"发生错误： " + ex.getMessage() );
		
		// 这里有2种选择 ， 跳转到指定的错误页面
		// 
/*		ModelAndView error = new ModelAndView("error");
		error.addObject("exMsg", ex.getMessage());
		error.addObject("exType", ex.getClass().getSimpleName().replace("\"", ";"))
		*/
		
		//返回json 格式的错误信息
		
		try {
			
			PrintWriter writer = response.getWriter();
			
			BaseResult<String> result = new BaseResult<>(false, ex.getMessage()) ;
			
			writer.write(JSON.toJSONString(result));
			writer.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("exception",e);
		}
		
		
		
		
		return null;
	}

}
