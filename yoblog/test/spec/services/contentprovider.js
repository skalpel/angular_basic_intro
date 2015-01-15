'use strict';

describe('Service: contentProvider', function () {

  beforeEach(module('yoblogApp'));

  var contentProvider;
  var $httpBackend;

  beforeEach(inject(function (_contentProvider_, _$httpBackend_) {
    contentProvider = _contentProvider_;
    $httpBackend = _$httpBackend_;
  }));

  afterEach(function () {
    $httpBackend.verifyNoOutstandingExpectation();
    $httpBackend.verifyNoOutstandingRequest();
  });

  it('should send http GET to /posts when getting latest posts', function () {
    $httpBackend.expectGET('http://localhost:4567/posts').respond(201, {posts: []});
    contentProvider.getLatestPosts(
      function () {
      },
      function () {
      });
    $httpBackend.flush();
  });

  it('should send http POST to /posts when adding new post', function () {
    $httpBackend.expectPOST('http://localhost:4567/posts').respond(201, '');
    contentProvider.addPost(
      {},
      function () {
      },
      function () {
      });
    $httpBackend.flush();
  });

  it('should return only 3 posts when getting latest posts', function () {
    $httpBackend.whenGET('http://localhost:4567/posts').respond(201, {posts: [
      {author: 'author', title: 'title', content: 'content', date: 1},
      {author: 'author', title: 'title', content: 'content', date: 2},
      {author: 'author', title: 'title', content: 'content', date: 3},
      {author: 'author', title: 'title', content: 'content', date: 4},
      {author: 'author', title: 'title', content: 'content', date: 5},
    ]});

    var result;
    contentProvider.getLatestPosts(
      function (posts) {
        result = posts;
      },
      function () {
      });
    $httpBackend.flush();

    expect(result).not.toBeUndefined();
    expect(result.length).toEqual(3);
  });

  it('should return only latest posts when getting latest posts', function () {
    $httpBackend.whenGET('http://localhost:4567/posts').respond(201, {posts: [
      {author: 'author', title: 'title', content: 'content', date: 1},
      {author: 'author', title: 'title', content: 'content', date: 2},
      {author: 'author', title: 'title', content: 'content', date: 3},
      {author: 'author', title: 'title', content: 'content', date: 4},
      {author: 'author', title: 'title', content: 'content', date: 5},
    ]});

    var result;
    contentProvider.getLatestPosts(
      function (posts) {
        result = posts;
      },
      function () {
      });
    $httpBackend.flush();

    expect(result[0].date).toEqual(5);
    expect(result[1].date).toEqual(4);
    expect(result[2].date).toEqual(3);
  });

});
