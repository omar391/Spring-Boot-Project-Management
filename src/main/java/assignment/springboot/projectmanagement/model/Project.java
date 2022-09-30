package assignment.springboot.projectmanagement.model;

import assignment.springboot.projectmanagement.entities.Projects;

import java.util.List;

public class Project {

    public static class CreateRequest {
        public final String name;
        public final String desc;
        public final String owner;
        public CreateRequest(String name, String desc, String owner) {
            this.name = name;
            this.desc = desc;
            this.owner = owner;
        }
    }

    public static class ListRequest {
        public final int pageNo;
        public final int count;

        public ListRequest(int pageNo, int count) {
            this.pageNo = pageNo;
            this.count = count;
        }
    }

    public static class ListResponse {
        public final State state;
        public final String msg;
        public final ListData data;

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

    public static class ListData {
        public final int total;
        public final List<Projects> list;

        public ListData(int total, List<Projects> list) {
            this.total = total;
            this.list = list;
        }
    }
}
