package maria.anikina.setvice;

import maria.anikina.model.Post;

import java.util.*;
import java.util.stream.Collectors;

public class PostServiceImplCustom implements PostService {
	public final int NUMBER_OF_POSSIBLE_VALUES_OF_ONE_DIGIT = 10;

	public List<Post> getTop10(List<Post> posts) {
		Post postMaxLikes = posts.stream().max(Comparator.comparingInt(Post::getLikesCount)).orElse(null);
		int numberLength = String.valueOf(postMaxLikes.getLikesCount()).length();
		List<Post> postsFilter = new ArrayList<>();
		while (numberLength > 0) {
				int finalNumberLength1 = numberLength;
				for (int i = NUMBER_OF_POSSIBLE_VALUES_OF_ONE_DIGIT - 1; i >= 0; i--) {
					if (postsFilter.size() < 10) {
						int finalI = i;
						postsFilter.addAll(
							posts.stream()
									.filter(
											post -> String.valueOf(post.getLikesCount()).length() == finalNumberLength1 &&
											 String.valueOf(post.getLikesCount()).substring(0, 1).equals(String.valueOf(finalI))
											)
									.collect(Collectors.toList())
					) ;
				}
			}
				numberLength--;
		}
		postsFilter.sort((p1, p2) -> p2.getLikesCount() - p1.getLikesCount());
		return postsFilter.subList(0, 10);
	}

}
