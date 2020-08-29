import request from '@/utils/request'

// 查询贷款使用列表
export function listUsage(query) {
  return request({
    url: '/amount/usage/list',
    method: 'get',
    params: query
  })
}

// 查询贷款使用详细
export function getUsage(id) {
  return request({
    url: '/amount/usage/' + id,
    method: 'get'
  })
}

// 新增贷款使用
export function addUsage(data) {
  return request({
    url: '/amount/usage',
    method: 'post',
    data: data
  })
}

// 修改贷款使用
export function updateUsage(data) {
  return request({
    url: '/amount/usage',
    method: 'put',
    data: data
  })
}

// 删除贷款使用
export function delUsage(id) {
  return request({
    url: '/amount/usage/' + id,
    method: 'delete'
  })
}

// 导出贷款使用
export function exportUsage(query) {
  return request({
    url: '/amount/usage/export',
    method: 'get',
    params: query
  })
}