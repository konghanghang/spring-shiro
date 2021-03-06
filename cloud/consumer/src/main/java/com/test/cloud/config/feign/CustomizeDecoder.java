package com.test.cloud.config.feign;

import com.iminling.common.json.JsonUtil;
import com.iminling.model.common.ResultModel;
import com.iminling.model.exception.BizException;
import feign.FeignException;
import feign.Response;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * 自定义解码器
 * @author yslao@outlook.com
 * @since 2021/3/28
 */
public class CustomizeDecoder extends SpringDecoder {

    public CustomizeDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        ResultModel resultModel;
        Class<ResultModel> clazz = ResultModel.class;
        resultModel = decodeByType(response, clazz);
        if (resultModel.getCode() != 200) {
            throw new BizException("请求异常：" + resultModel.getMessage());
        }
        Object data = resultModel.getData();
        return JsonUtil.convert(data, type);
    }

    private <T> T decodeByType(Response response, Class<T> clazz) throws IOException {
        return (T) super.decode(response, clazz);
    }
}
