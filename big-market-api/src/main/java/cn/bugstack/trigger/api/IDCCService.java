package cn.bugstack.trigger.api;

import cn.bugstack.types.model.Response;


public interface IDCCService {
    public Response<Boolean> updateConfig( String key,  String value);
}
