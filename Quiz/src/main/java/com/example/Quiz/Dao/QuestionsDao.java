package com.example.Quiz.Dao;

import com.example.Quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Question,Integer> {
     List<Question> findAllByCategory(String cate);
     @Query(value = "select * from question as q where q.category=:category order by rand() limit :numQ",nativeQuery = true)
     List<Question> findRandomQuestionByCategory(String category, int numQ);
}
