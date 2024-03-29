#!/usr/local/bin/python
# -*- coding: UTF-8 -*-

def twoSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    result = []
    dict = {}
    for i, num in enumerate(nums):
        if dict.has_key(target - num):
            result = [dict.get(target - num), i]
        else:
            dict[num] = i
    return result

def longestCommonPrefix(strs):
    """
    :type strs: List[str]
    :rtype: str
    """
    if len(strs) == 0:
        return ""
    if len(strs) == 1:
        return strs[0]
    idx = 0
    is_break = False
    while True:
        if idx >= len(strs[0]) or is_break:
            break
        ch = strs[0][idx]
        for i, str in enumerate(strs[1:]):
            if idx >= len(str):
                is_break = True
                break
            if ch != str[idx]:
                return strs[0][0:idx]
        if i == len(strs) - 2 and not is_break:
            idx += 1
    return strs[0][0:idx]


def removeKdigits(num, k):
    """
    :type num: str
    :type k: int
    :rtype: str
    """
    result = ''
    nums = list(num)
    idx = 0
    count = 0
    for i, ch in enumerate(nums[1:]):
        if count == k:
            break
        if nums[idx] < ch:
            nums[i + 1] = -1
            count += 1
        else:
            nums[idx] = -1
            idx = i + 1
            count += 1
    print(nums)
    for i, ch in enumerate(nums):
        if ch == '0' and len(result) == 0:
            continue
        if ch != -1:
            result += str(ch)
    return result


def myAtoi(s):
    """
    :type s: str
    :rtype: int
    """
    arr = list(s)
    i = 0
    size = len(arr)
    print(arr)
    if size == 0:
        return 0
    while i < size and arr[i] == ' ':
        i += 1
    if i >= size or (arr[i] != '+' and arr[i] != '-' and (arr[i] > '9' or arr[i] < '0')):
        return 0
    isNegative = False
    if arr[i] == '-':
        isNegative = True
    if arr[i] == '-' or arr[i] == '+':
        i += 1
    if i >= size or (arr[i] > '9' or arr[i] < '0'):
        return 0
    j = i
    while j < size and '0' <= arr[j] <= '9':
        j += 1
    if i == j:
        return 0
    num = long(''.join(arr[i:min(j, i + 11)]))
    if isNegative and -num <= -2**31:
        return -2**31
    if not isNegative and num >= 2**31 - 1:
        return 2**31 - 1
    if isNegative:
        return -num
    else:
        return num

def main():
    nums = [2, 7, 11, 15]
    target = 9
    nums = [3, 2, 4]
    target = 6
    # nums = [3, 3]
    # target = 6
    # print(twoSum(nums, target))

    # strs = ["flower", "flow", "flight"]
    # strs = ["dog", "racecar", "car"]
    # strs = ['dog']
    # strs = ['', '']
    # strs = ["ab", "a"]
    # print(longestCommonPrefix(strs))

    # num = "10200"
    # k = 1
    # print(removeKdigits(num, k))

    s = '-91283472332'
    print(myAtoi(s))


if __name__ == "__main__":
    main()
