package maria.anikina.setvice;

import maria.anikina.model.Post;

import java.util.List;

public interface PostService {
	List<Post> getTop10(List<Post> posts);
}
