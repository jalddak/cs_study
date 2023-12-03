from multiprocessing import Process
import os

def foo():
    print("foo : current process : ", os.getpid())
    print("foo : parent process : ", os.getppid())

def test1():
    for i in range(5):
        print("test1 executed : ", i)

def test2():
    for i in range(5):
        print("test2 executed : ", i)

def test3():
    for i in range(5):
        print("test3 executed : ", i)

if __name__ == "__main__":
    print("process : ", os.getpid())
    print("parent process : ", os.getppid())
    print("\n일반적인 실행")
    foo()
    
    # 동시 수행이라서 프린트도 의도대로 안됨
    print("\n멀티 프로세싱으로 실행")
    child1 = Process(target=foo).start()
    print("\n멀티 프로세싱으로 실행")
    child2 = Process(target=foo).start()
    print("\n멀티 프로세싱으로 실행")
    child3 = Process(target=foo).start()


    child4 = Process(target=test1).start()
    child5 = Process(target=test2).start()
    child6 = Process(target=test3).start()