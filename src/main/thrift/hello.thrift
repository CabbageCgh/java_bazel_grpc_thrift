namespace java com.example.grpc.thrift.template

service HelloService {
    string greeting(1: string name)
}


struct Message {
    1: i64 id,
    2: string name,
    3: string content,
    4: string sendTime
}