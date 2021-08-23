// package com.example.demo.Infraestructure;


// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.NoRepositoryBean;



// @NoRepositoryBean
// public interface MyJPARepository<T, ID> extends CrudRepository<T, ID>{

//     @Override
//     default <S extends T> S save(S entity){
//     //    return JpaRepository.save(entity);
//     CrudRepository.super.save(entity);
//     return entity;
// //       CrudRepository.super.save(entity);
//      //   return CrudRepository.super.save(entity);
//     }
    
// }
