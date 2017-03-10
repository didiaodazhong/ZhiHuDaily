package com.peixing.zhihudaily.model;

import java.util.List;

/**
 * Created by peixing on 2017/3/9.
 */

public class ResponseLatees {

    /**
     * date : 20170309
     * stories : [{"images":["http://pic2.zhimg.com/e4aa51fb6f034f14b439704f3fafb175.jpg"],"type":0,"id":9276137,"ga_prefix":"030917","title":"书中确实有黄金屋，至少 18 世纪欧洲的崛起就是个例子"},{"title":"销魂美味 松花鸡腿","ga_prefix":"030916","images":["http://pic1.zhimg.com/bd2b7f3f92b533aa35f4434e8d37cf64.jpg"],"multipic":true,"type":0,"id":9269115},{"images":["http://pic3.zhimg.com/490329f340eac7ba3a42471d7ca21c6e.jpg"],"type":0,"id":9275945,"ga_prefix":"030915","title":"几百块的手机也要指纹识别，于是芯片市场又火了"},{"images":["http://pic3.zhimg.com/f58841dbae29b22cbdd6d89a524fe976.jpg"],"type":0,"id":9198534,"ga_prefix":"030914","title":"老王煎饼果子公司的上市之路"},{"images":["http://pic4.zhimg.com/4f9665a1a920cc5d139dd9c68636e2e7.jpg"],"type":0,"id":9275902,"ga_prefix":"030913","title":"靠着直播，陌陌赚了不少钱，盈利能力超过了微博"},{"images":["http://pic3.zhimg.com/41aa8d3163f78a9d8fa2955252e09a1e.jpg"],"type":0,"id":9275502,"ga_prefix":"030912","title":"大误 · 大话西游中的隐藏剧情"},{"images":["http://pic1.zhimg.com/70a5d60f74d21a28c2ed39d4c6525460.jpg"],"type":0,"id":9275334,"ga_prefix":"030911","title":"「四大」的人才培养不复杂，可别人就是很难复制"},{"title":"月球表面那么多陨石坑，为什么没看到陨石？","ga_prefix":"030910","images":["http://pic3.zhimg.com/230d0ceb19c8282e78d957e4ebe32716.jpg"],"multipic":true,"type":0,"id":9275298},{"images":["http://pic2.zhimg.com/fa16f1af2e164d3a6befda771d281039.jpg"],"type":0,"id":9274670,"ga_prefix":"030909","title":"除了 4S 店，别地方卖车我还真不太敢去"},{"title":"美股投资应该如何入门？","ga_prefix":"030908","images":["http://pic1.zhimg.com/c97c2f3f3c30c9710a25fa30e8f0b2c8.jpg"],"multipic":true,"type":0,"id":9274300},{"images":["http://pic2.zhimg.com/19cc44546cac1d56a4a23da6c50ee341.jpg"],"type":0,"id":9273386,"ga_prefix":"030907","title":"「拍卖锤落下的那一瞬间，才明白，自己被诅咒了」"},{"images":["http://pic3.zhimg.com/b687c1b5216478a8ec25c402389065e6.jpg"],"type":0,"id":9274296,"ga_prefix":"030907","title":"鱼刺卡在喉咙里喝醋没用，喝多少都没用"},{"images":["http://pic3.zhimg.com/87514496467cb7fd9f3d5280123d72ce.jpg"],"type":0,"id":9271263,"ga_prefix":"030907","title":"回过头去看，英国真的有必要「征服」印度吗？"},{"images":["http://pic1.zhimg.com/29e7ddc2a19b038b3c261daf29460908.jpg"],"type":0,"id":9271383,"ga_prefix":"030906","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/287a31b1a17abefc08e7bf4cee5f754f.jpg","type":0,"id":9275902,"ga_prefix":"030913","title":"靠着直播，陌陌赚了不少钱，盈利能力超过了微博"},{"image":"http://pic1.zhimg.com/79f84b3e4deb2ca79a2e704196b89cf0.jpg","type":0,"id":9198534,"ga_prefix":"030914","title":"老王煎饼果子公司的上市之路"},{"image":"http://pic4.zhimg.com/59877e50e4539f361621386fcabdebd7.jpg","type":0,"id":9269115,"ga_prefix":"030916","title":"销魂美味 松花鸡腿"},{"image":"http://pic2.zhimg.com/298008981f6413b82e2835162652f1fd.jpg","type":0,"id":9273684,"ga_prefix":"030815","title":"NBA 和微博成了合作伙伴，腾讯：我可能买到了假版权"},{"image":"http://pic1.zhimg.com/b08e7d45c0e19bd75248bcbb1cd255c4.jpg","type":0,"id":9269719,"ga_prefix":"030807","title":"「你看，女性数量越少的学科，平均智商越高」"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic2.zhimg.com/e4aa51fb6f034f14b439704f3fafb175.jpg"]
         * type : 0
         * id : 9276137
         * ga_prefix : 030917
         * title : 书中确实有黄金屋，至少 18 世纪欧洲的崛起就是个例子
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic4.zhimg.com/287a31b1a17abefc08e7bf4cee5f754f.jpg
         * type : 0
         * id : 9275902
         * ga_prefix : 030913
         * title : 靠着直播，陌陌赚了不少钱，盈利能力超过了微博
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
