//package com.keanghor.java.miniproject.repository;
//
//
//import com.keanghor.java.miniproject.model.entity.HabitLog;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@Mapper
//public interface HabitLogRepository {
//    @Results(id = "habitLogMapper", value = {
//            @Result(property = "logId", column = "log_id"),
//            @Result(property = "logDate", column = "log_date"),
//            @Result(property = "status", column = "status"),
//            @Result(property = "xpEarned", column = "xp_earned"),
//            @Result(property = "habitId", column = "habit_id"),
//    })
//    @Select("""
//            SELECT * FROM habit_logs WHERE habit_id = #{habitId} OFFSET #{offset} LIMIT #{limit}
//            """)
//    List<HabitLog> getHabitLogsByHabitId(@Param("habitId") UUID habitId, @Param("offset") Integer offset, @Param("limit") Integer limit);
//
//    @ResultMap("habitLogMapper")
//    @Select("""
//            SELECT * FROM habit_logs WHERE log_id = #{logId}
//            """)
//    HabitLog getHabitLogById(@Param("logId") UUID logId);
//
//    @Insert("""
//            INSERT INTO habit_logs (log_id, log_date, status, xp_earned, habit_id)
//            VALUES (#{logId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler}, #{logDate}, #{status},
//            #{xpEarned}, #{habitId, typeHandler=com.team3.sr.java.miniproject.config.UuidTypeHandler})
//            """)
//    void insert(HabitLog habitLog);
//}
//
