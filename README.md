# RoomCoroutineApp

```
@Dao
abstract class InfoDao {

    @Insert
    abstract suspend fun insert( info : Info )

    @Query( "DELETE FROM Info" )
    abstract suspend fun deleteAll()

    @Transaction
    open suspend fun deleteAllAndInsert( info : Info ) {
        deleteAll()
        insert( info )
    }
}
```

Compilation fails for suspend version of deleteAllAndInsert

Method annotated with @Transaction must not return deferred/async return type androidx.lifecycle.LiveData. Since transactions are thread confined and Room cannot guarantee that all queries in the method implementation are performed on the same thread, only synchronous @Transaction implemented methods are allowed. If a transaction is started and a change of thread is done and waited upon then a database deadlock can occur if the additional thread attempts to perform a query. This restrictions prevents such situation from occurring.
