import com.axue.framework.sdk.core.common.DefaultProfile;
import com.axue.framework.sdk.core.common.ServerException;
import com.axue.framework.sdk.message.param.AddCustomMessageParam;
import com.axue.framework.sdk.message.request.AddCustomMessageRequest;
import com.axue.framework.sdk.message.response.AddCustomMessageResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddCustomMessageTest {

    public final static String endpoint = "http://127.0.0.1:8550";

    public void addCustomMessageTest() throws ServerException {
        AddCustomMessageParam param = new AddCustomMessageParam();
        param.setSendType(1);
        param.setTenementCode("b7820833901b4464a28188160c1ad9d8");
        String[] personCode = {"9708156df3eb435690156bf1892868b4"};
        param.setPersonCodes(personCode);
        param.setSubMessageType("message_type:personal:order_todo");
        param.setContent("消息内容");
        DefaultProfile client = new DefaultProfile(endpoint);
        AddCustomMessageResponse response = client.getAcsResponse(new AddCustomMessageRequest(param));
        log.info("------------->{}", response.getData());
    }

}