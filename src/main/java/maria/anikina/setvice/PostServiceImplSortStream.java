package maria.anikina.setvice;

import maria.anikina.model.Post;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImplSortStream implements PostService {
	@Override
	public List<Post> getTop10(List<Post> posts) {
		return posts.stream()
				.sorted((p1, p2) -> p2.getLikesCount() - p1.getLikesCount())
				.limit(10)
				.collect(Collectors.toList());
	}
}
