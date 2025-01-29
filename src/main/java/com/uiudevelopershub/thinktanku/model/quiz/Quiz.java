package com.uiudevelopershub.thinktanku.model.quiz;

import com.uiudevelopershub.thinktanku.model.quizresult.QuizResult;
import com.uiudevelopershub.thinktanku.model.quizsession.QuizSession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;


import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Quiz {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
   // @SequenceGenerator( name = "quiz_gen", sequenceName = "quiz_seq", allocationSize = 1 )
    @Column( name = "id", nullable = false )
    private Long id;

    @Column( nullable = false )
    private String questionTitle;

    @Column( nullable = false )
    private String questionAnswer;

    @Column( nullable = false )
    private String optionOne;

    @Column( nullable = false )
    private String optionTwo;

    @Column( nullable = false )
    private String optionThree;

    @Column( nullable = false )
    private String optionFour;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "quiz_session_id" )
    private QuizSession quizSession;

//    @Override
//    public final boolean equals( Object o ) {
//        if ( this == o ) return true;
//        if ( o == null ) return false;
//        Class< ? > oEffectiveClass = o instanceof HibernateProxy ? ( ( HibernateProxy ) o ).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
//        Class< ? > thisEffectiveClass = this instanceof HibernateProxy ? ( ( HibernateProxy ) this ).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
//        if ( thisEffectiveClass != oEffectiveClass ) return false;
//        Quiz quiz = ( Quiz ) o;
//        return getId() != null && Objects.equals( getId(), quiz.getId() );
//    }

    @Override
    public final int hashCode( ) {
        return this instanceof HibernateProxy ? ( ( HibernateProxy ) this ).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

        @OneToMany(mappedBy = "quiz")  // 'quiz' refers to the field in QuizResult class
       private List<QuizResult> quizResults;
}