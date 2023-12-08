package maria.anikina.setvice;

import maria.anikina.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostServiceImplSortCollection implements PostService {
	@Override
	public List<Post> getTop10(List<Post> posts) {
		posts.sort((p1, p2) -> p2.getLikesCount() - p1.getLikesCount());
		List<Post> postTop10 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			postTop10.add(posts.get(i));
		}
		return postTop10;
	}
}
