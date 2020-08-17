import request from '@/utils/request'

// 查询采购订单跟踪信息列表
export function listInformation(query) {
  return request({
    url: '/amount/information/list',
    method: 'get',
    params: query
  })
}

// 查询采购订单跟踪信息详细
export function getInformation(id) {
  return request({
    url: '/amount/information/' + id,
    method: 'get'
  })
}

// 新增采购订单跟踪信息
export function addInformation(data) {
  return request({
    url: '/amount/information',
    method: 'post',
    data: data
  })
}

// 修改采购订单跟踪信息
export function updateInformation(data) {
  return request({
    url: '/amount/information',
    method: 'put',
    data: data
  })
}

// 删除采购订单跟踪信息
export function delInformation(id) {
  return request({
    url: '/amount/information/' + id,
    method: 'delete'
  })
}

// 导出采购订单跟踪信息
export function exportInformation(query) {
  return request({
    url: '/amount/information/export',
    method: 'get',
    params: query
  })
}