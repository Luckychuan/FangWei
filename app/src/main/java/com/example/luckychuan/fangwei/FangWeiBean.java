package com.example.luckychuan.fangwei;

/**
 * Created by Luckychuan on 2017/11/3.
 */

public class FangWeiBean {

    private boolean success;
    private int msgcode;
    private Data data;

    @Override
    public String toString() {
        return "FangWeiBean{" +
                "success=" + success +
                ", msgcode=" + msgcode +
                ", data=" + data.toString() +
                '}';
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(int msgcode) {
        this.msgcode = msgcode;
    }



    public class Data{
        private String ResultHTML;
        private String ResultImg;
        private int ResultMsgID;

        public String getResultHTML() {
            return ResultHTML;
        }

        public void setResultHTML(String resultHTML) {
            ResultHTML = resultHTML;
        }

        public String getResultImg() {
            return ResultImg;
        }

        public void setResultImg(String resultImg) {
            ResultImg = resultImg;
        }

        public int getResultMsgID() {
            return ResultMsgID;
        }

        public void setResultMsgID(int resultMsgID) {
            ResultMsgID = resultMsgID;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "ResultHTML='" + ResultHTML + '\'' +
                    ", ResultImg='" + ResultImg + '\'' +
                    ", ResultMsgID='" + ResultMsgID + '\'' +
                    '}';
        }
    }

}
