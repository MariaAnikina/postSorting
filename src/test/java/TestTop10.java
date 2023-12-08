import maria.anikina.model.Post;
import maria.anikina.setvice.PostService;
import maria.anikina.setvice.PostServiceImplCustom;
import maria.anikina.setvice.PostServiceImplSortCollection;
import maria.anikina.setvice.PostServiceImplSortStream;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestTop10 {
	private List<Post> list = fillOutList();
	private PostService postServiceCustom = new PostServiceImplCustom();
	private PostService postServiceCollection = new PostServiceImplSortCollection();
	private PostService postServiceStream = new PostServiceImplSortStream();
	private Random random;


	private List<Post> fillOutList() {
		random = new Random();
		list = new ArrayList<>(1_000_000);
		int sizeList = 1_000_000;
		while (list.size() < sizeList) {
			list.add(new Post(random.nextInt(1_000_000)));
		}
		return list;
	}

	@Test
	public void test1() {
		System.out.println("Кастомная сортировка");
		long startTime = System.currentTimeMillis();
		for (Post post : postServiceCustom.getTop10(list)) {
			System.out.println("Лайков у поста: " + post.getLikesCount());
		};
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	}

	@Test
	public void test2() {
		System.out.println("Сортировка с помощью метода класса Collections");
		long startTime = System.currentTimeMillis();
		for (Post post : postServiceCollection.getTop10(list)) {
			System.out.println("Лайков у поста: " + post.getLikesCount());
		};
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	}

	@Test
	public void test3() {
		System.out.println("Сортировка с помощью стимов");
		long startTime = System.currentTimeMillis();
		for (Post post : postServiceStream.getTop10(list)) {
			System.out.println("Лайков у поста: " + post.getLikesCount());
		}
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed);
	}
}
