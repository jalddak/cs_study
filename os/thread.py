import threading
import os

def foo():
    print("foo: threadID: ", threading.get_native_id())
    print("foo: my pid: ", os.getpid())

def test():
    for i in range(10):
        print("test: threadID: ", threading.get_native_id(), i)
        print("test: my pid: ", os.getpid(), i)

if __name__ == "__main__":
    print("my pid: ", os.getpid())
    thread1 = threading.Thread(target=foo).start()
    thread2 = threading.Thread(target=foo).start()

    thread3 = threading.Thread(target=test).start()
    thread4 = threading.Thread(target=test).start()
    thread5 = threading.Thread(target=test).start()