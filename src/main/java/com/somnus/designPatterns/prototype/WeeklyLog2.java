package com.somnus.designPatterns.prototype;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Title: WeeklyLog2.java
 * @Package com.somnus.designPatterns.prototype
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月25日 下午1:26:43
 * @version V1.0
 */
// 工作周报WeeklyLog
class WeeklyLog2 implements Cloneable {
    // 为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，可以通过List等集合对象来实现
    private Attachment2 attachment;
    private String name;
    private String date;
    private String content;
    
    public WeeklyLog2(Attachment2 attachment) {
		super();
		this.attachment = attachment;
	}

	public void setAttachment(Attachment2 attachment) {
        this.attachment = attachment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment2 getAttachment() {
        return (this.attachment);
    }

    public String getName() {
        return (this.name);
    }

    public String getDate() {
        return (this.date);
    }

    public String getContent() {
        return (this.content);
    }

    // 使用clone()方法实现浅克隆
    public WeeklyLog2 clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog2) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }
    
    static class Attachment2 {
        private String name; // 附件名
        
        public Attachment2(String name) {
			super();
			this.name = name;
		}

		public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void download() {
            System.out.println("下载附件，文件名为" + name);
        }
        
        @Override
        public String toString() {  
        	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
        }
    }
}

