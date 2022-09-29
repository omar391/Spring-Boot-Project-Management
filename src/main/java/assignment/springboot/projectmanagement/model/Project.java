package assignment.springboot.projectmanagement.model;

import assignment.springboot.projectmanagement.entities.Projects;

import java.util.List;

public class Project {

    public static class CreateRequest {
        public String name;
        public String desc;
        public long ownerId;
    }

    public static class ListRequest {
        public int pageNo;
        public int count;
    }

    public static class ListResponse{
        public State state;
        public String msg;
        public ListData data;

        public ListResponse(State state, String msg, ListData data) {
            this.state = state;
            this.msg = msg;
            this.data = data;
        }

        public enum State {
            FAILURE(0), SUCCESS(1);
            private final int value;
            State(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }
        }
    }

    public static class ListData{
        public int total;
        public List<Projects> list;

        public ListData(int total, List<Projects> list) {
            this.total = total;
            this.list = list;
        }
    }
}
